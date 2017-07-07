package es.lavandadelpatio.auto.TelegramModels;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by raulm on 07/07/2017.
 */
public enum MessageEntityType {
    /**
     * Ex: @username
     */
    @JsonProperty("mention") MENTION,

    @JsonProperty("hashtag") HASHTAG,

    @JsonProperty("bot_command") BOT_COMMAND,

    @JsonProperty("utl") URL,

    @JsonProperty("email") EMAIL,

    /**
     * Bold Text
     */
    @JsonProperty("bold") BOLD,

    /**
     * Italic Text
     */
    @JsonProperty("italic") ITALIC,

    /**
     * Monowidth string
     */
    @JsonProperty("code") CODE,

    /**
     * Monowidth block
     */
    @JsonProperty("pre") PRE,

    /**
     * for clickable text URLs
     */
    @JsonProperty("text_link") TEXT_LINK,

    /**
     * for users without username
     */
    @JsonProperty("text_mention") TEXT_MENTION

}
