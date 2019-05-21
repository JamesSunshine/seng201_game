package main;

import main.Types.*;

public class CrewFactory {

    public CrewMember recruit(String type, String name) {
        switch (type) {
            case "engineer": {
                return new Engineer(name);
            }

            case "medic": {
                return new Medic(name);
            }

            case "grunt": {
                return new Grunt(name);
            }

            case "gunner": {
                return new Gunner(name);
            }

            case "pilot": {
                return new Pilot(name);
            }

            case "scout": {
                return new Scout(name);
            }
        }
        return null;
    }
}
