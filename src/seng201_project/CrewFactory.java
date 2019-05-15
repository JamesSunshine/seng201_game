package seng201_project;

import seng201_project.Types.*;

public class CrewFactory extends CrewMember {

    CrewFactory(String mName) {
        super(mName);
    }

    CrewMember recruit(String type, String name) {
        switch (type) {
            case "engineer":
                crewList.add(new Engineer(name));

            case "medic":
                crewList.add(new Medic(name));

            case "grunt":
                crewList.add(new Grunt(name));

            case "gunner": {
                crewList.add(new Gunner(name));
            }
            case "pilot": {
                crewList.add(new Pilot(name));
            }
            case "scout": {
                crewList.add(new Scout(name));
            }
        }

        // FIXME: Remove me later;
        return new Engineer("ERROR");
    }
}
