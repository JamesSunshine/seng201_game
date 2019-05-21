package main;

import main.Types.*;

public class CrewFactory {

    CrewMember recruit(String type, String name) {
        switch (type) {
            case "engineer": {
                return Ship.addCrew(new Engineer(name));
            }

            case "medic": {
                return Ship.addCrew(new Medic(name));
            }

            case "grunt": {
                return Ship.addCrew(new Grunt(name));
            }

            case "gunner": {
                return Ship.addCrew(new Gunner(name));
            }

            case "pilot": {
                return Ship.addCrew(new Pilot(name));
            }

            case "scout": {
                return Ship.addCrew(new Scout(name));
            }
        }
        return null;
    }
}
