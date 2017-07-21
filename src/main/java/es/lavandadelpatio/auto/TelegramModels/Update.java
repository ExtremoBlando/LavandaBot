package es.lavandadelpatio.auto.TelegramModels;

import javax.persistence.Entity;
import java.util.Optional;

/**
 * Created by raulm on 07/07/2017.
 */
public class Update {

    /**
     * The update‘s unique identifier. Update identifiers start from a certain positive number and increase sequentially. This ID becomes especially handy if you’re using Webhooks, since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order.
     */
    int update_id;

    /**
     * New incoming message of any kind — text, photo, sticker, etc.
     */
    Optional<Message> message;

    /**
     * New version of a message that is known to the bot and was edited
     */
    Optional<Message> edited_message;

    /**
     * New incoming channel post of any kind — text, photo, sticker, etc.
     */
    Optional<Message> channel_post;

    /**
     * New version of a channel post that is known to the bot and was edited
     */
    Optional<Message> edited_channel_post;

    /**
     * New incoming inline query
     */
    Optional<InlineQuery> inline_query;

    /**
     * The result of an inline query that was chosen by a user and sent to their chat partner.
     */
    Optional<ChosenInlineResult> chosen_inline_result;

    /**
     * New incoming callback query
     */
    Optional<CallbackQuery> callback_query;

    /**
     * New incoming shipping query. Only for invoices with flexible price
     */
    Optional<ShippingQuery> shipping_query;

    /**
     * New incoming pre-checkout query. Contains full information about checkout
     */
    Optional<PreCheckoutQuery> pre_checkout_query;

    public int getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(int update_id) {
        this.update_id = update_id;
    }

    public Optional<Message> getMessage() {
        return message;
    }

    public void setMessage(Optional<Message> message) {
        this.message = message;
    }

    public Optional<Message> getEdited_message() {
        return edited_message;
    }

    public void setEdited_message(Optional<Message> edited_message) {
        this.edited_message = edited_message;
    }

    public Optional<Message> getChannel_post() {
        return channel_post;
    }

    public void setChannel_post(Optional<Message> channel_post) {
        this.channel_post = channel_post;
    }

    public Optional<Message> getEdited_channel_post() {
        return edited_channel_post;
    }

    public void setEdited_channel_post(Optional<Message> edited_channel_post) {
        this.edited_channel_post = edited_channel_post;
    }

    public Optional<InlineQuery> getInline_query() {
        return inline_query;
    }

    public void setInline_query(Optional<InlineQuery> inline_query) {
        this.inline_query = inline_query;
    }

    public Optional<ChosenInlineResult> getChosen_inline_result() {
        return chosen_inline_result;
    }

    public void setChosen_inline_result(Optional<ChosenInlineResult> chosen_inline_result) {
        this.chosen_inline_result = chosen_inline_result;
    }

    public Optional<CallbackQuery> getCallback_query() {
        return callback_query;
    }

    public void setCallback_query(Optional<CallbackQuery> callback_query) {
        this.callback_query = callback_query;
    }

    public Optional<ShippingQuery> getShipping_query() {
        return shipping_query;
    }

    public void setShipping_query(Optional<ShippingQuery> shipping_query) {
        this.shipping_query = shipping_query;
    }

    public Optional<PreCheckoutQuery> getPre_checkout_query() {
        return pre_checkout_query;
    }

    public void setPre_checkout_query(Optional<PreCheckoutQuery> pre_checkout_query) {
        this.pre_checkout_query = pre_checkout_query;
    }

    // TODO: Message optionality
/*    public String toString(){
        if(this.message.isPresent())
            return "Tiene mensaje";
        if(this.callback_query.isPresent())
            return "Es un callback query";
        if(this.channel_post.isPresent())
            return "Es un channel post";
        if(this.chosen_inline_result.isPresent())
            return "Es un chosen inline result";
        if(this.edited_channel_post.isPresent())
            return "Es un edited channel post";
        if(this.edited_message.isPresent())
            return "Es un mensaje editado";
        if(this.inline_query.isPresent())
            return "Inline query";
        if(this.pre_checkout_query.isPresent())
            return "Pre checkout query";
        if(this.shipping_query.isPresent())
            return "Shipping Query";
        return "Me cago en tus muertos";
    }*/
}

