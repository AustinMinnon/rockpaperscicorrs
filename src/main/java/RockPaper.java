import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class RockPaper {
  public static void main(String[] args) {}
//     String layout = "templates/layout.vtl";
// //
//     get("/", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       model.put("template", "templates/player1.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
// //
//     get("/detector", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       model.put("template", "templates/detector.vtl");
// //
//       String user1Input = request.queryParams("user1Input");
//       String user2Input = request.queryParams("user2Input");
//
//       model.put("checkWinner", checkWinner);
//       model.put("user1Input", request.queryParams("results1"));
//       model.put("user2Input", request.queryParams("results2"));
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//   }
// //

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
}
