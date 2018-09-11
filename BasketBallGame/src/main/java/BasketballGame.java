
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author softwareguild
 */
public class BasketballGame {

    public static void main(String[] args) {
        Random random = new Random();
        int yourPossession = 10;
        int opponentsPossession = 11;
        UserInterface io = new ConsoleImplementationUserInterface();
        String rockets = "";
        String warriors = "";
        String celtics = "";
        String caviliars = "";
        int possessionsPerTeamForOpponetsTeam = 0;
        String userInputEnterInOpponentsTeam = "";
        int possessionsPerTeamForYourTeam = 0;
        String userInputEnterInTeamToPlayWith;
        int totalPoints = 0;
        int pointsPerPossession = 0;
        int yourTeamsTotalPoints = 0;
        int opponetsTeamTotalPoints = 0;

        do {
            userInputEnterInTeamToPlayWith = io.readString("Enter in a team to play Rockets, Warriors, Celtics, or Caviliars");

            io.print(userInputEnterInOpponentsTeam);

            if (!userInputEnterInTeamToPlayWith.equalsIgnoreCase("rockets")
                    && !userInputEnterInTeamToPlayWith.equalsIgnoreCase("warriors")
                    && !userInputEnterInTeamToPlayWith.equalsIgnoreCase("celtics")
                    && !userInputEnterInTeamToPlayWith.equalsIgnoreCase("caviliars")) {
                io.print("=== ERROR === Please select a team from above");
            }

        } while (!userInputEnterInTeamToPlayWith.equalsIgnoreCase("rockets")
                && !userInputEnterInTeamToPlayWith.equalsIgnoreCase("warriors")
                && !userInputEnterInTeamToPlayWith.equalsIgnoreCase("celtics")
                && !userInputEnterInTeamToPlayWith.equalsIgnoreCase("caviliars"));

        do {

            if (userInputEnterInTeamToPlayWith.equalsIgnoreCase("rockets")
                    || userInputEnterInTeamToPlayWith.equalsIgnoreCase("warriors")
                    || userInputEnterInTeamToPlayWith.equalsIgnoreCase("celtics")
                    || userInputEnterInTeamToPlayWith.equalsIgnoreCase("caviliars")) {

                if (userInputEnterInTeamToPlayWith.equalsIgnoreCase("rockets")) {
                    userInputEnterInOpponentsTeam = io.readString("Enter in a team to play the " + userInputEnterInTeamToPlayWith
                            + " - Warriors, Celtics, or Caviliars");
                    if (!userInputEnterInOpponentsTeam.equalsIgnoreCase("warriors")
                            && !userInputEnterInOpponentsTeam.equalsIgnoreCase("celtics")
                            && !userInputEnterInOpponentsTeam.equalsIgnoreCase("caviliars")) {
                        io.print("=== ERROR === Please select a team from above");
                    }
                } else if (userInputEnterInTeamToPlayWith.equalsIgnoreCase("warriors")) {
                    userInputEnterInOpponentsTeam = io.readString("Enter in a team to play the " + userInputEnterInTeamToPlayWith
                            + " - Rockets, Celtics, or Caviliars");
                    if (!userInputEnterInOpponentsTeam.equalsIgnoreCase("rockets")
                            && !userInputEnterInOpponentsTeam.equalsIgnoreCase("celtics")
                            && !userInputEnterInOpponentsTeam.equalsIgnoreCase("caviliars")) {
                        io.print("=== ERROR === Please select a team from above");
                    }
                } else if (userInputEnterInTeamToPlayWith.equalsIgnoreCase("celtics")) {
                    userInputEnterInOpponentsTeam = io.readString("Enter in a team to play the " + userInputEnterInTeamToPlayWith
                            + " - Rockets, Warriors, or Caviliars");
                    if (!userInputEnterInOpponentsTeam.equalsIgnoreCase("rockets")
                            && !userInputEnterInOpponentsTeam.equalsIgnoreCase("warriors")
                            && !userInputEnterInOpponentsTeam.equalsIgnoreCase("caviliars")) {
                        io.print("=== ERROR === Please select a team from above");
                    }
                } else if (userInputEnterInTeamToPlayWith.equalsIgnoreCase("caviliars")) {
                    userInputEnterInOpponentsTeam = io.readString("Enter in a team to play the " + userInputEnterInTeamToPlayWith
                            + " - Rockets, Warriors, Celtics");
                    if (!userInputEnterInOpponentsTeam.equalsIgnoreCase("rockets")
                            && !userInputEnterInOpponentsTeam.equalsIgnoreCase("warriors")
                            && !userInputEnterInOpponentsTeam.equalsIgnoreCase("celtics")) {
                        io.print("=== ERROR === Please select a team from above");
                    }
                }
            }
        } while (!userInputEnterInOpponentsTeam.equalsIgnoreCase("rockets")
                && !userInputEnterInOpponentsTeam.equalsIgnoreCase("warriors")
                && !userInputEnterInOpponentsTeam.equalsIgnoreCase("celtics")
                && !userInputEnterInOpponentsTeam.equalsIgnoreCase("caviliars"));

        if (userInputEnterInTeamToPlayWith.equalsIgnoreCase("rockets")) {
            possessionsPerTeamForYourTeam = 101;
        } else if (userInputEnterInTeamToPlayWith.equalsIgnoreCase("warriors")) {
            possessionsPerTeamForYourTeam = 102;
        } else if (userInputEnterInTeamToPlayWith.equalsIgnoreCase("celtics")) {
            possessionsPerTeamForYourTeam = 99;
        } else if (userInputEnterInTeamToPlayWith.equalsIgnoreCase("caviliars")) {
            possessionsPerTeamForYourTeam = 100;
        }

        if (userInputEnterInOpponentsTeam.equalsIgnoreCase("rockets")) {
            possessionsPerTeamForOpponetsTeam = 101;
        } else if (userInputEnterInOpponentsTeam.equalsIgnoreCase("warriors")) {
            possessionsPerTeamForOpponetsTeam = 102;
        } else if (userInputEnterInOpponentsTeam.equalsIgnoreCase("celtics")) {
            possessionsPerTeamForOpponetsTeam = 99;
        } else if (userInputEnterInOpponentsTeam.equalsIgnoreCase("caviliars")) {
            possessionsPerTeamForOpponetsTeam = 100;
        }
        playGame(random, userInputEnterInTeamToPlayWith, userInputEnterInOpponentsTeam, io, opponetsTeamTotalPoints, yourTeamsTotalPoints);
    }

    public static void determineWhoWinsTheTipOff(Random random, String userInputEnterInTeamToPlayWith,
            String userInputEnterInOpponentsTeam, UserInterface io) {
        int winsTheTip = random.nextInt(1) + 2;

        if (winsTheTip == 1) {
            io.print(userInputEnterInTeamToPlayWith + " win the opening tip!");
        } else if (winsTheTip == 2) {
            io.print(userInputEnterInOpponentsTeam + " win the opening tip!");
        }
    }

    public static void runPossessionAndPointsForYourTeam(Random random, int possessionsPerTeamForYourTeam,
            String userInputEnterInTeamToPlayWith, UserInterface io, int yourTeamsTotalPoints) {

        for (int i = 0; i < possessionsPerTeamForYourTeam; i++) {
            int toDetermineHowManyPointsYourTeamScoresPerPossession = random.nextInt(4) + 1;
            if (toDetermineHowManyPointsYourTeamScoresPerPossession == 1) {
                int pointsPerPossessionYourTeam = 0;
                yourTeamsTotalPoints = pointsPerPossessionYourTeam + yourTeamsTotalPoints;
            }
            if (toDetermineHowManyPointsYourTeamScoresPerPossession == 2) {
                int pointsPerPossessionYourTeam = 1;
                yourTeamsTotalPoints = pointsPerPossessionYourTeam + yourTeamsTotalPoints;
            }
            if (toDetermineHowManyPointsYourTeamScoresPerPossession == 3) {
                int pointsPerPossessionYourTeam = 2;
                yourTeamsTotalPoints = pointsPerPossessionYourTeam + yourTeamsTotalPoints;
            }
            if (toDetermineHowManyPointsYourTeamScoresPerPossession == 4) {
                int pointsPerPossessionYourTeam = 3;
                yourTeamsTotalPoints = pointsPerPossessionYourTeam + yourTeamsTotalPoints;
            }

            io.print(userInputEnterInTeamToPlayWith + ": " + yourTeamsTotalPoints);

        }
    }

    public static void runPossessionAndPointsForOpponentsTeam(Random random, int possessionsPerTeamForOpponetsTeam,
            String userInputEnterInOpponentsTeam, UserInterface io, int opponetsTeamTotalPoints) {
        for (int j = 0; j < possessionsPerTeamForOpponetsTeam; j++) {
            int toDetermineHowManyPointsOpponentsTeamScoresPerPossession = random.nextInt(4) + 1;
            if (toDetermineHowManyPointsOpponentsTeamScoresPerPossession == 1) {
                int pointsPerPossessionOpponentsTeam = 0;
                opponetsTeamTotalPoints = pointsPerPossessionOpponentsTeam + opponetsTeamTotalPoints;
            }
            if (toDetermineHowManyPointsOpponentsTeamScoresPerPossession == 2) {
                int pointsPerPossessionOpponentsTeam = 1;
                opponetsTeamTotalPoints = pointsPerPossessionOpponentsTeam + opponetsTeamTotalPoints;
            }
            if (toDetermineHowManyPointsOpponentsTeamScoresPerPossession == 3) {
                int pointsPerPossessionOpponentsTeam = 2;
                opponetsTeamTotalPoints = pointsPerPossessionOpponentsTeam + opponetsTeamTotalPoints;
            }
            if (toDetermineHowManyPointsOpponentsTeamScoresPerPossession == 4) {
                int pointsPerPossessionOpponentsTeam = 3;
                opponetsTeamTotalPoints = pointsPerPossessionOpponentsTeam + opponetsTeamTotalPoints;
            }
        }
        io.print(userInputEnterInOpponentsTeam + ": " + opponetsTeamTotalPoints);

    }

    public static void printMessagesForWinningTeam(String userInputEnterInTeamToPlayWith, UserInterface io,
            String userInputEnterInOpponentsTeam) {

        if (userInputEnterInTeamToPlayWith.equalsIgnoreCase("rockets")
                || userInputEnterInOpponentsTeam.equalsIgnoreCase("rockets")) {
            io.print("Chris Paul isn't one of the all-time greats. He's one of the all-time great LOSERS.");
            io.print("Do it in the playoffs and if you do it in the playoffs...");
            io.print("Do it in the Conference Finals and if you do it in the Confence Finals...");
            io.print("Do it in the Finals");
        } else if (userInputEnterInTeamToPlayWith.equalsIgnoreCase("warriors")
                || userInputEnterInOpponentsTeam.equalsIgnoreCase("warriors")) {
            io.print("In my Personal Record Book the Warriors did not win this game");
        } else if (userInputEnterInTeamToPlayWith.equalsIgnoreCase("caviliars")
                || userInputEnterInOpponentsTeam.equalsIgnoreCase("caviliars")) {
            io.print("=== LEBRON ===");
        } else if (userInputEnterInTeamToPlayWith.equalsIgnoreCase("celtics")
                || userInputEnterInOpponentsTeam.equalsIgnoreCase("celtics")) {
            io.print("Kyrie played?!?!");
            io.print("I thought we was injured");
        }
    }

    public static void playGame(Random random, String userInputEnterInTeamToPlayWith, String userInputEnterInOpponentsTeam,
            UserInterface io, int opponetsTeamTotalPoints, int yourTeamsTotalPoints) {
        determineWhoWinsTheTipOff(random, userInputEnterInTeamToPlayWith, userInputEnterInOpponentsTeam, io);
        runPossessionAndPointsForYourTeam(random, 0, userInputEnterInTeamToPlayWith, io, yourTeamsTotalPoints);
        runPossessionAndPointsForOpponentsTeam(random, 0, userInputEnterInOpponentsTeam, io, opponetsTeamTotalPoints);

        io.print(userInputEnterInOpponentsTeam + ": " + opponetsTeamTotalPoints);
        io.print(userInputEnterInTeamToPlayWith + ": " + yourTeamsTotalPoints);
    }
}
