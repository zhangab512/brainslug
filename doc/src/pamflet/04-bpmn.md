# BPMN

brainslug is able to export flow definitions to BPMN 2.0 as image or XML definitions file.

## Renderer Example

```java
    JGraphRenderer renderer = new JGraphRenderer(new GraphFactory());
    FileOutputStream outputStream = ...
    FlowBuilder flowBuilder = ...
    renderer.render(flowBuilder, outputStream, Format.PNG);
```

![task_flow](images/task_flow.png)

also check [JGraphRendererTest](https://github.com/adrobisch/brainslug/blob/master/renderer/src/test/java/brainslug/flow/renderer/JGraphRendererTest.java).

## XML Definitions export

```java
    FlowBuilder flowBuilder =  new FlowBuilder() {
                                 @Override
                                 public void define() {
                                   start(event(id("start")))
                                     .execute(task(id("task")).display("A Task"))
                                     .execute(task(id("task2")).display("Another Task"))
                                   .end(event(id("end")));
                                 }
                               };
    BpmnModelTransformer bpmnModelTransformer = new BpmnModelTransformer();
    String bpmnXml = bpmnModelTransformer.toBpmnXml(flowBuilder);
```

will produce

```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <definitions xmlns="http://www.omg.org/spec/BPMN/20100524/MODEL" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:activiti="http://activiti.org/bpmn" xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI" xmlns:omgdc="http://www.omg.org/spec/DD/20100524/DC" xmlns:omgdi="http://www.omg.org/spec/DD/20100524/DI" typeLanguage="http://www.w3.org/2001/XMLSchema" expressionLanguage="http://www.w3.org/1999/XPath" targetNamespace="http://www.activiti.org/test">
    <process id="471ff134-4050-497b-bf80-d1fa5164f311" name="471ff134-4050-497b-bf80-d1fa5164f311" isExecutable="true">
      <startEvent id="start" name="start"></startEvent>
      <serviceTask id="task" name="A Task"></serviceTask>
      <serviceTask id="task2" name="Another Task"></serviceTask>
      <endEvent id="end" name="end"></endEvent>
      <sequenceFlow sourceRef="start" targetRef="task"></sequenceFlow>
      <sequenceFlow sourceRef="task" targetRef="task2"></sequenceFlow>
      <sequenceFlow sourceRef="task2" targetRef="end"></sequenceFlow>
    </process>
    <bpmndi:BPMNDiagram id="BPMNDiagram_471ff134-4050-497b-bf80-d1fa5164f311">
      <bpmndi:BPMNPlane bpmnElement="471ff134-4050-497b-bf80-d1fa5164f311" id="BPMNPlane_471ff134-4050-497b-bf80-d1fa5164f311"></bpmndi:BPMNPlane>
    </bpmndi:BPMNDiagram>
  </definitions>
```

also check [BpmnModelTransformerTest](https://github.com/adrobisch/brainslug/blob/master/bpmn/src/test/java/brainslug/bpmn/BpmnModelTransformerTest.java).