import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class RockPaper {
  public static void main(String[] args) {
    staticFileLocation("/public");

    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/player1.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/player2", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/player2.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/detector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/detector.vtl");

      String user1Input = request.queryParams("user1Input");
      String user2Input = request.queryParams("user2Input");
      String winner = whoWon(user1Input, user2Input);

      model.put("winner", winner);
      model.put("user1Input", request.queryParams("results1"));
      model.put("user2Input", request.queryParams("results2"));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static Boolean checkWinner(String user1Input, String user2Input) {
    Boolean gameResult = false;
    if (user1Input.equals("paper") && user2Input.equals("rock")) {
      gameResult = true;
    } else if (user1Input.equals("rock") && user2Input.equals("scissors")) {
      gameResult = true;
    } else if (user1Input.equals("scissors") && user2Input.equals("paper")) {
      gameResult = true;
    }
    return gameResult;
  }
  public static String whoWon(String player1, String player2) {
    String winner = "";
    if (checkWinner(player1, player2)) {
      winner = "Player1 Wins";
    } else if (checkWinner(player2, player1)) {
      winner = "Player2 Wins";
    } else {
      winner = "Tie, play again.";
    }
    return winner;
  }
}
