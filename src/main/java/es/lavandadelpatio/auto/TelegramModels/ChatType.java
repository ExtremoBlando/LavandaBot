package es.lavandadelpatio.auto.TelegramModels;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by raulm on 07/07/2017.
 */
public enum ChatType {
    @JsonProperty("private") PRIVATE,
    @JsonProperty("group") GROUP,
    @JsonProperty("supergroup") SUPERGROUP,
    @JsonProperty("channel") CHANNEL
}
