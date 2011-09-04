package de.jebc.tutorial.graphiti.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

public class MyTutorialDiagramTypeProvider extends AbstractDiagramTypeProvider {

	public MyTutorialDiagramTypeProvider() {
		super();
		setFeatureProvider(new TutorialFeatureProvider(this));
	}
}
