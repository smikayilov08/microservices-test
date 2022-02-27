package az.unec.managerinfoservice.service;

import az.unec.managerinfoservice.data.ManagersDTO;
import az.unec.managerinfoservice.data.Managers;
import az.unec.managerinfoservice.data.AllManagersDTO;
import az.unec.managerinfoservice.data.MangersRepo;
import az.unec.managerinfoservice.exception.MyNullPointerException;
import az.unec.managerinfoservice.exception.ManagerAlreadyEx;
import az.unec.managerinfoservice.exception.ManagerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ManagersService {
    @Autowired
    private MangersRepo repo;

    public ManagersDTO saveManager(ManagersDTO manager) {
        if (manager==null  || manager.getManagerName()==null || manager.getManagerName().trim().length()<3 ||
        manager.getClubName()==null || manager.getClubName().trim().length()<3
        || manager.getNationality()==null || manager.getNationality().trim().length()<3){
            throw new MyNullPointerException("Please fill all fields");
        }
        else if(repo.findByClubName(manager.getClubName()).isPresent()){
                throw new ManagerAlreadyEx("Manager already exist ");
        }
        repo.save(new Managers(manager.getManagerName(), manager.getNationality(), manager.getClubName()));
        return manager;
    }

    public ManagersDTO getManager(String name) {
        if (name==null || name.trim().length()<3){
            throw new MyNullPointerException("Please fill all fields");
        }
        Optional<ManagersDTO> manager=repo.findByClubName(name);
        manager.orElseThrow(()->new ManagerNotFoundException("Manager Not Found"));
        return manager.get();
    }


    public String deleteManager(String clubName) {
        if(clubName==null || clubName.trim().length()<3){
            throw new MyNullPointerException("Please fill all fields");
        }
       else if (repo.deleteByClubName(clubName) == 1) {
            return "Succesfully deleted";
        } else {
            throw new ManagerNotFoundException("Manager not found");
        }
    }

    public AllManagersDTO getAllManagers(){
        List<ManagersDTO> managers=repo.findAllByClubNameNotNull();
        if(managers.isEmpty()){
            throw  new ManagerNotFoundException("Doesn't exist");
        }

        return new AllManagersDTO(managers);
    }
}
