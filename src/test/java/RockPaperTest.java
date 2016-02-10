
import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class RockPaperTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  // @ClassRule
  // public static ServerRule server = new ServerRule();
  //
  // @Test
  // public void rootTest() {
  //     goTo("http://localhost:4567/");
  //     assertThat(pageSource()).contains("Rock, Paper, Scissors");
  // }
  // @Test
  // public void rockPaperScissors() {
  //   goTo("http://localhost:4567");
  //   fill("#user1Input").with("rock");
  //   fill("#user2Input").with("paper");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("player2 wins");
  // }

//   @Test
//   public void checkWinner_tieRockRock_tie() {
//   RockPaper testRockPaper = new RockPaper();
//   assertEquals("it's a tie", testRockPaper.checkWinner("Rock", "Rock"));
// }
  @Test
  public void checkWinner_rockBeatsScissors_rockwins() {
    RockPaper testRockPaper = new RockPaper();
    assertEquals(true, testRockPaper.checkWinner("rock", "scissors"));
  }
  @Test
  public void checkWinner_ScissorsBeatsPaper_scissorswins() {
    RockPaper testRockPaper = new RockPaper();
    assertEquals(true, testRockPaper.checkWinner("scissors", "paper"));
  }
  @Test
  public void checkWinner_PaperBeatsRock_rockwins() {
    RockPaper testRockPaper = new RockPaper();
    assertEquals(true, testRockPaper.checkWinner("paper", "rock"));
  }
}
