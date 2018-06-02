package pl.bskorka.springExpressions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.test.context.junit4.SpringRunner;

public class SpringExpressionsApplicationTests {

	private ExpressionParser parser = new SpelExpressionParser();

	@Test
	public void spel_find_enum_and_call_parse_method_to_get_registered_state_enum() {
		Expression expression = parser.parseExpression("T(pl.bskorka.springExpressions.TestyClassy.State).parse('R')");
		TestyClassy.State state  = expression.getValue(TestyClassy.State.class);
		Assert.assertEquals(TestyClassy.State.REGISTERED, state);
	}

	@Test
	public void spel_find_enum_and_get_value_of_registered() {
		Expression expression = parser.parseExpression("T(pl.bskorka.springExpressions.TestyClassy.State).REGISTERED.getValue()");
		String stateValue  = expression.getValue(String.class);
		Assert.assertEquals(TestyClassy.State.REGISTERED.getValue(), stateValue);
	}

}
