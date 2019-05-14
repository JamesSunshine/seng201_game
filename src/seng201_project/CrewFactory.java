package seng201_project;

import seng201_project.Types.*;

class CrewFactory {

    private int nCreated = 0;

    CrewFactory() {
        nCreated = 0;
    }

    CrewMember recruit(String type, String name) {
        switch (type) {
            case "engineer":
                return new Engineer(name);

            case "medic":
                return new Medic(name);

            case "grunt":
                return new Grunt(name);

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

        // FIXME: Remove me later;
        return new Engineer("ERROR");
    }
}
