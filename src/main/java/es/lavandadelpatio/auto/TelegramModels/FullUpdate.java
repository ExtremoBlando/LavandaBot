package es.lavandadelpatio.auto.TelegramModels;

import javax.persistence.Entity;

/**
 * Created by raulm on 08/07/2017.
 */

public class FullUpdate {
    boolean ok;
    Update[] result;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public Update[] getResult() {
        return result;
    }

    public void setResult(Update[] result) {
        this.result = result;
    }
}
