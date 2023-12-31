package action.gui.element_action;

import assertion.Assertion;
import assertion.TextAssertion;
import lombok.Getter;

@Getter
public class ElementTextAction {
    private final String text;

    protected ElementTextAction(String text) {
        this.text = text;
    }

    public TextAssertion assertThat() {
        return Assertion.assertThat(text);
    }
}
