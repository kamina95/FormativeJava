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
import motorboat.business.Novice;
import motorboat.business.MBLH;

public class DAOImplementation implements DAO {

    @Override
    public Motorboat[] getMotorboat() {
        Motorboat[] arr = new Motorboat[10];
        arr[0] = new Motorboat("Speedy");
        arr[1] = new Motorboat("Escape");
        arr[2] = new Motorboat("Spirit");
        arr[3] = new Motorboat("Destiny");
        arr[4] = new Motorboat("Elden");
        arr[5] = new Motorboat("Karma");
        arr[6] = new Motorboat("Sea ya");
        arr[7] = new Motorboat("Devocean");
        arr[8] = new Motorboat("Osprey");
        arr[9] = new Motorboat("Misty");

        return arr;
    }

    @Override
    public ArrayList<Instructor> getInstructors() {
        
        ArrayList<Instructor> instructors = new ArrayList<>();
        
        instructors.add(new Instructor("Pepe"));
        instructors.add(new Instructor("Jose"));
        instructors.add(new Instructor("Antonio"));
        instructors.add(new Instructor("Cristiano"));
        instructors.add(new Instructor("Laura"));
        instructors.add(new Instructor("Maria"));
        instructors.add(new Instructor("Lorein"));
        instructors.add(new Instructor("Julia"));
        instructors.add(new Instructor("Lucia"));

        return instructors;
    }

    @Override
    public ArrayList<Member> getMembers() {
        
        ArrayList<Instructor> instructors = getInstructors();
        ArrayList<Member> members = new ArrayList<>();
        Motorboat[] motorboats = getMotorboat();
        
        members.add(new Novice("Teresa", instructors.get(0)));
        members.add(new Novice("Monica", instructors.get(0)));
        members.add(new Novice("Timmy", instructors.get(0)));
        members.add(new Novice("Brandon", instructors.get(1)));
        members.add(new Novice("Sanderson", instructors.get(1)));
        members.add(new Novice("Aragon", instructors.get(1)));
        members.add(new Novice("Frodo", instructors.get(2)));
        members.add(new Novice("Sam", instructors.get(2)));
        members.add(new Novice("Vin", instructors.get(2)));
        members.add(new Novice("Leonar", instructors.get(3)));
        members.add(new Novice("Rocio", instructors.get(3)));
        members.add(new Novice("Luffy", instructors.get(3)));
        members.add(new Novice("Paolo", instructors.get(4)));
        members.add(new Novice("Tolkien", instructors.get(4)));
        members.add(new Novice("Lidu", instructors.get(4)));
        members.add(new Novice("Rosalia", instructors.get(5)));
        members.add(new Novice("Pepito", instructors.get(5)));
        members.add(new Novice("Juanito", instructors.get(5)));
        members.add(new Novice("Sara", instructors.get(6)));
        members.add(new Novice("Mata", instructors.get(6)));
        members.add(new Novice("Loreta", instructors.get(6)));
        members.add(new Novice("Pepita", instructors.get(7)));
        members.add(new Novice("Suiza", instructors.get(7)));
        members.add(new Novice("Julen", instructors.get(7)));
        members.add(new Novice("Paco", instructors.get(8)));
        members.add(new Novice("Chema", instructors.get(8)));
        members.add(new Novice("Steven", instructors.get(8)));
        members.add(new MBLH("Rooger"));
        members.add(new MBLH("Stand"));
        members.add(new MBLH("Cloe"));
        members.add(new MBLH("Tulipa"));
        members.add(new MBLH("Hulk"));
        members.add(new MBLH("Peroni"));
        members.add(new MBLH("Sacha"));
        members.add(new MBLH("Cuba"));
        members.add(new MBLH("Chispa"));
        members.add(new MBLH("Fideo"));
        members.add(new MBLH("Jose"));
        members.add(new MBLH("Sandra"));
        members.add(new MBLH("Puche"));
        members.add(new MBLH("Ana"));
        
        members.get(0).addLesson(0, 0, instructors.get(0), motorboats[0]);
        members.get(0).addLesson(2, 7, instructors.get(0), motorboats[1]);
        members.get(0).addLesson(1, 1, instructors.get(0), motorboats[0]);
        members.get(0).addLesson(0, 7, instructors.get(0), motorboats[2]);
        members.get(1).addLesson(1, 3, instructors.get(0), motorboats[3]);
        members.get(1).addLesson(6, 2, instructors.get(0), motorboats[4]);
        members.get(1).addLesson(2, 5, instructors.get(0), motorboats[0]);
        members.get(2).addLesson(4, 0, instructors.get(0), motorboats[1]);
        members.get(2).addLesson(0, 4, instructors.get(0), motorboats[1]);
        members.get(1).addLesson(2, 8, instructors.get(0), motorboats[2]);
        members.get(0).addLesson(0, 0, instructors.get(0), motorboats[1]);
        members.get(0).addLesson(0, 0, instructors.get(4), motorboats[7]);
        members.get(0).addLesson(0, 0, instructors.get(0), motorboats[2]);
        members.get(0).addLesson(0, 0, instructors.get(0), motorboats[1]);
        members.get(0).addLesson(0, 0, instructors.get(0), motorboats[0]);
        members.get(0).addLesson(0, 0, instructors.get(0), motorboats[9]);
        members.get(0).addLesson(0, 0, instructors.get(0), motorboats[5]);
        members.get(0).addLesson(0, 0, instructors.get(0), motorboats[6]);
        members.get(0).addLesson(0, 0, instructors.get(0), motorboats[3]);
        members.get(0).addLesson(0, 0, instructors.get(0), motorboats[2]);
        members.get(0).addLesson(0, 0, instructors.get(0), motorboats[3]);
        
        
        
        return members;
    }
}
