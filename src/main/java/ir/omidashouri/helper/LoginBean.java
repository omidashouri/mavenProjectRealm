/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ir.omidashouri.helper;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author omid
 */

@Stateless
@Named
public class LoginBean {
  private String username;
  private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



  public String login () {
      FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest  request = (HttpServletRequest)  context.getExternalContext().getRequest();
//    String remoteUser = request.getRemoteUser();
//    String remoteUser2 = context.getExternalContext().getRemoteUser();
    try {
      request.login(this.username, this.password);
    } catch (ServletException e) {
      context.addMessage(null, new FacesMessage("Login failed."));
      return "loginerror";
    }
    return "admins/index";
  }

  public void logout() {
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    try {
      request.logout();
    } catch (ServletException e) {
      context.addMessage(null, new FacesMessage("Logout failed."));
    }
  }
}
