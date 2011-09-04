package de.jebc.tutorial.graphiti.diagram;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import de.jebc.tutorial.graphiti.features.TutorialAddEClassFeature;

public class TutorialFeatureProvider extends DefaultFeatureProvider {

	public TutorialFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}

	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		if (context.getNewObject() instanceof EClass)
			return new TutorialAddEClassFeature(this);
		return super.getAddFeature(context);
	}
}
