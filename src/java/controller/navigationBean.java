/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author LENOVO
 */

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class navigationBean implements Serializable {

    public String page(String page) {
        return "/secret/" + page + "/" +"list?faces-redirect=true";
    }

}
