package com.latido.security;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.latido.model.LatidoFacade;
import com.latido.model.entities.UsuRol;
import com.latido.model.entities.Usuario;

public class LatidoSecurityManager {
	public static final String USERNAME = "USERINLINE";
	public static final String ROLES = "ASSIGNEDROLES";
	public static final String USEROBJECT = "USEROBJECT";


	/**
	 * @return the session
	 */
	public static HttpSession getSession() {
		return (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	}
	/**
	 * Una vez que tenemos al usuario validado se carga la información incial de el.
	 * 
	 * */
	public static void registerUserInSession(String userName) throws Exception{
		if(userName != null) {
			Usuario user = LatidoFacade.getInstance().getfullUserByUsername(userName);
			if(user != null) {
				HttpSession session  = getSession();
				session.setAttribute(USERNAME, userName);
				String[] roles = new String[] {};
				int index = 0;
				if(user.getUsuRol() != null)
					for(UsuRol ur : user.getUsuRol()) {
						roles[index++] = ur.getRol().getNombre(); 
					}
				session.setAttribute(USEROBJECT, user);
				session.setAttribute(ROLES, roles);
			} else {
				throw new Exception ("User not found or inactivated ...");
			}
			
		} else {
			throw new Exception ("The user cannot be null ...");
		}
	}
	
	public static String getUserInLine() {
		return (String) getSession().getAttribute(USERNAME);
	}
	
	public static String[] getUserRoles() {
		return (String[]) getSession().getAttribute(ROLES);
	}
	
	public static Usuario getUserObject() {
		return (Usuario) getSession().getAttribute(USEROBJECT);
	}

}
