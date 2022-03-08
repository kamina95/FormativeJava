/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motorboat.data;

import java.util.ArrayList;
import motorboat.business.Instructor;
import motorboat.business.Member;
import motorboat.business.Motorboat;

/**
 *
 * @author anton
 */
public interface DAO {
    abstract public Motorboat[] getMotorboat();
    abstract public ArrayList<Instructor> getInstructors();
    abstract public ArrayList<Member> getMembers();
}
