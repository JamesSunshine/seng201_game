package seng201_project;

public class CrewType {

        public String typeString;
        public int hp;
        public int hungerChange;
        public int tirednessChange;
        public String specSkill;
        public int cost;


        public static void main(String[] args) {

            CrewType engineer = new CrewType();     //engineer crew type
            engineer.typeString = "engineer";
            engineer.hp = 15;
            engineer.hungerChange = 2;
            engineer.tirednessChange = 2;
            engineer.specSkill = "engineer";
            engineer.cost = 5;

            CrewType pilot = new CrewType();       //pilot crew type
            pilot.typeString = "pilot";
            pilot.hp = 10;
            pilot.hungerChange = 2;
            pilot.tirednessChange = 2;
            pilot.specSkill = "pilot";
            pilot.cost = 3;

            CrewType medic = new CrewType();
            medic.typeString = "medic";
            medic.hp = 15;
            medic.hungerChange = 2;
            medic.tirednessChange = 2;
            medic.specSkill = "medic";
            medic.cost = 4;

            CrewType scout = new CrewType();
            scout.typeString = "scout";
            scout.hp = 15;
            scout.hungerChange = 2;
            scout.tirednessChange = 2;
            scout.specSkill = "scout";
            scout.cost = 6;

            CrewType grunt = new CrewType();
            grunt.typeString = "grunt";
            grunt.hp = 15;
            grunt.hungerChange = 1;
            grunt.tirednessChange = 1;
            grunt.specSkill = "grunt";
            grunt.cost = 1;

            CrewType gunner = new CrewType();
            gunner.typeString = "gunner";
            gunner.hp = 15;
            gunner.hungerChange = 2;
            gunner.tirednessChange = 1;
            gunner.specSkill = "gunner";
            gunner.cost = 2;

        }
}
