package com.aem.community.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = "AEMMaven13/components/content/validationexample")
public class ValidationExampleModel implements Validatable {

	@SlingObject
	Resource resource;

	@ChildResource(name = "coverImage")
	ImageModel coverImage;

	private Validation validation;

	@PostConstruct
	public void setup() {
/*		validation = new Validation().reporError(isInvalidCoverImages(), "The image must be specified.")
				.reportWarning(isInvalidAspectRatioForCoverImages(), "Image aspect ratio should be 16:9.")
				.reportInfo(true, "Put some more images, that will look awesome!");
		*/
		validation = new Validation().reporError(true, "There is an error, must be fixed!")
				.reportWarning(true, "There is a warning, please check configuration!")
				.reportInfo(true, "This is just information, can be ignored!");
		
	}

	public ImageModel getCoverImage() {
		return coverImage;
	}

	private static boolean isImageAssetEmpty(ImageModel imageModel) {
		return imageModel == null || imageModel.getAsset() == null;
	}

	private boolean isInvalidCoverImages() {
		return isImageAssetEmpty(coverImage);
	}

	private boolean isInvalidAspectRatioForCoverImages() {
		return (!isInvalidCoverImages() && !ImageRequirements.ASPECT_RATIO_16_9.isSatisfiedBy(coverImage));
	}

	@Override
	public Validation getValidation() {
		return validation;
	}

}
