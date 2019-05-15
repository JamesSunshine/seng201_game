package seng201_project;

import seng201_project.Types.*;

public class CrewFactory {

    CrewMember recruit(String type, String name) {
        switch (type) {
            case "engineer":
                Ship.addCrew(new Engineer(name));

            case "medic":
                Ship.addCrew(new Medic(name));

            case "grunt":
                Ship.addCrew(new Grunt(name));

            case "gunner": {
                Ship.addCrew(new Gunner(name));
            }
            case "pilot": {
                Ship.addCrew(new Pilot(name));
            }
            case "scout": {
                Ship.addCrew(new Scout(name));
            }
        }

        // FIXME: Remove me later;
        return new Engineer("ERROR");
    }
}
