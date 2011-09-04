package de.jebc.tutorial.graphiti.features;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

public class TutorialAddEClassFeature extends AbstractAddShapeFeature {

	public TutorialAddEClassFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canAdd(IAddContext context) {
		if (context.getNewObject() instanceof EClass
				&& context.getTargetContainer() instanceof Diagram)
			return true;
		return false;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		EClass addedClass = (EClass) context.getNewObject();
		Diagram targetDiagram = (Diagram) context.getTargetContainer();

		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape = peCreateService.createContainerShape(
				targetDiagram, true);

		int width = 100;
		int height = 50;

		IGaService gaService = Graphiti.getGaService();

		RoundedRectangle roundedRectangle = gaService.createRoundedRectangle(
				containerShape, 5, 5);
		gaService.setLocationAndSize(roundedRectangle, context.getX(),
				context.getY(), width, height);

		if (addedClass.eResource() == null)
			getDiagram().eResource().getContents().add(addedClass);
		
		link(containerShape, addedClass);
		
		return null;
	}

}
