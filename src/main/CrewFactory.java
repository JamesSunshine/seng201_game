package main;

import main.Types.*;

public class CrewFactory {

    /**
     * Recruit a crewmember
     *
     * @param type the type
     * @param name the name
     * @return the crew member
     */
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
