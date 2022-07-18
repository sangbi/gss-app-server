package com.gss.web.api.validator;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;
import com.gss.web.api.validator.UserSingupValidationGroup.NotEmptyGroup;
import com.gss.web.api.validator.UserSingupValidationGroup.PatternCheckGroup;

@GroupSequence({Default.class,NotEmptyGroup.class,PatternCheckGroup.class,})
public interface ValidationSequence {
}
