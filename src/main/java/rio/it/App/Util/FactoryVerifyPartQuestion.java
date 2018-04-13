package rio.it.App.Util;

import javax.validation.constraints.NotNull;

/**
 * Created by chien on 12/04/2018.
 */
public interface FactoryVerifyPartQuestion {
    VerifyPartQuestion getVerify(@NotNull PartEnum part);
}
