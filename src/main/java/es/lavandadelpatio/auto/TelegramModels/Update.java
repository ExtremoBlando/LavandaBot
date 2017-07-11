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
}

