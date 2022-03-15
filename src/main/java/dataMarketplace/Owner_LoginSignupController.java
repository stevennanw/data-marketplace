package dataMarketplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;

@Controller
public class Owner_LoginSignupController extends HttpServlet {
    @Autowired OwnerRepository ownerRepository;
    HashMap<Integer, Owner> ownerList = new HashMap<>();

    public void setAdminOwner(HashMap<Integer, Owner> ownerList) {
        this.ownerList = ownerList;
        Owner admin = new Owner();
        admin.setEmail("admin@goosecity.com");
        admin.setPassword("goosecity");
        ownerList.put(0,admin);
        count=1;
        admin_exist=1;
    }
    int count = 0;
    int admin_exist = 0;
    @GetMapping("/login-owner")
    public String loginOwner() {
        return "login-owner.html";
    }
    @PostMapping("/login-owner")
    public void loginOwner(Owner data, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException, SQLException {
      /*  if(admin_exist==0){
            setAdminOwner(ownerList);
        }
        for (int i = 0; i < count; i++) {
            String inEmail;
            String inPassword;
            inEmail = ownerList.get(i).getEmail();
            inPassword = ownerList.get(i).getPassword();
            if (Objects.equals(data.getEmail(), inEmail) && Objects.equals(data.getPassword(), inPassword)) {
                try {
                    response.sendRedirect("/owner-index");
                    break;
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            else{
                try {
                    response.sendRedirect("/owner-login-error-page");
                    break;
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }*/

        if(Validate.checkOwner(data.getPassword(), data.getEmail())){
            response.sendRedirect("/owner-index");
        }else{
            response.sendRedirect("/owner-login-error-page");
        }

    }

    @GetMapping("/owner-login-error-page")
    public String loginError() {
        return "login-error-page.html";
    }
    @GetMapping("/signup-owner")
    public String signupOwner() {
        return "signup-owner.html";
    }

    @PostMapping("/signup-owner")
    public void addOwner(Owner data, HttpServletResponse response) {
        Owner o = new Owner();
        o.setOwnerId(count);
        o.setPassword(data.getPassword());
        o.setEmail(data.getEmail());
        ownerRepository.save(o);
        //ownerList.put(count, o);
        count++;
        try {
            response.sendRedirect("/owner-index");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}