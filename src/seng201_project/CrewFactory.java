package seng201_project;

public class CrewFactory {

    private int nCreated = 0;

    CrewFactory() {
        nCreated = 0;
    }

    CrewMember recruit(String type, String name) {
        switch (type) {
            case "engineer": {
                return new Engineer(name);
            }
        }

        // FIXME: Remove me later;
        return new Engineer("ERROR");
    }
}
