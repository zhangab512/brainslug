package brainslug.flow.model;

import brainslug.flow.model.expression.EqualDefinition;

import java.util.ArrayList;
import java.util.List;

public class ChoiceDefinition extends FlowNodeDefinition<ChoiceDefinition> {

  FlowPathDefinition path;
  List<ThenDefinition> thenPaths = new ArrayList<ThenDefinition>();
  ThenDefinition otherwisePath;

  public ChoiceDefinition(FlowPathDefinition path) {
    this.path = path;
  }

  public ThenDefinition when(EqualDefinition predicateDefinition) {
    return addThenDefinition(new ThenDefinition(predicateDefinition, path.definition, this));
  }

  protected ThenDefinition addThenDefinition(ThenDefinition then) {
    thenPaths.add(then);
    return then;
  }

  public List<ThenDefinition> getThenPaths() {
    return thenPaths;
  }

  public ThenDefinition getOtherwisePath() {
    return otherwisePath;
  }

  public void setOtherwisePath(ThenDefinition otherwisePath) {
    this.otherwisePath = otherwisePath;
  }
}
