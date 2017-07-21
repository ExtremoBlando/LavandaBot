package es.lavandadelpatio.auto.TelegramModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Optional;

/**
 * Created by raulm on 07/07/2017.
 */
public class Message {

    /**
     * Unique message identifier inside this chat
     */
    @Id
    int message_id;

    /**
     * Sender, can be empty for messages sent to channels
     */
    Optional<User> from;

    /**
     *  Date the message was sent in Unix time
     */
    int date;

    /**
     * Conversation the message belongs to
     */
    Chat chat;

    /**
     * For forwarded messages, sender of the original message
     */
    Optional<User> forward_from;

    /**
     * For messages forwarded from a channel, information about the original channel
     */
    Optional<Chat> forward_from_chat;

    /**
     * For forwarded channel posts, identifier of the original message in the channel
     */
    Optional<Integer> forward_from_message_id;

    /**
     * For forwarded messages, date the original message was sent in Unix time
     */
    Optional<Integer> forward_date;

    /**
     * Date the message was last edited in Unix time
     */
    Optional<Integer> edit_date;

    /**
     * For replies, the original message. Note that the Message object in this field will not contain further
     * reply_to_message fields even if it itself is a reply.
     */
    Optional<Message> reply_to_message;

    /**
     * For text messages, the actual UTF-8 text of the message, 0-4096 characters.
     */
    Optional<String> text;

    /**
     * For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
     */
    Optional<MessageEntity[]> entities;

    /**
     * Message is an audio file, information about the file
     */
    Optional<Audio> audio;

    /**
     * Message is a general file, information about the file
     */
    Optional<Document> document;

    /**
     * Message is a game, information about the game.
     */
    Optional<Game> game;

    /**
     * Message is a photo, available sizes of the photo
     */
    Optional<PhotoSize[]> photo;

    /**
     * Message is a sticker, information about the sticker
     */
    Optional<Sticker> sticker;

    /**
     * Message is a video, information about the video
     */
    Optional<Video> video;

    /**
     * Message is a voice message, information about the file
     */
    Optional<Voice> voice;

    /**
     * Message is a video note, information about the video message
     */
    Optional<VideoNote> video_note;

    /**
     * New members that were added to the group or supergroup and information about them
     * (the bot itself may be one of these members)
     */
    Optional<User[]> new_chat_members;

    /**
     * Caption for the document, photo or video, 0-200 characters
     */
    Optional<String> caption;

    /**
     * Message is a shared contact, information about the contact
     */
    Optional<Contact> contact;

    /**
     * Message is a shared location, information about the location
     */
    Optional<Location> location;

    /**
     * Message is a venue, information about the venue
     */
    Optional<Venue> venue;

    /**
     * A new member was added to the group, information about them (this member may be the bot itself)
     */
    Optional<User> new_chat_member;

    /**
     * A member was removed from the group, information about them (this member may be the bot itself)
     */
    Optional<User> left_chat_member;

    /**
     * A chat title was changed to this value
     */
    Optional<String> new_chat_title;

    /**
     * A chat photo was change to this value
     */
    Optional<PhotoSize[]> new_chat_photo;

    /**
     * Service message: the chat photo was deleted
     */
    Optional<Boolean> delete_chat_photo;

    /**
     * Service message: the group has been created
     */
    Optional<Boolean> group_chat_created;

    /**
     * Service message: the supergroup has been created. This field can‘t be received in a message coming
     * through updates, because bot can’t be a member of a supergroup when it is created. It can only be found in
     * reply_to_message if someone replies to a very first message in a directly created supergroup.
     */
    Optional<Boolean> supergroup_chat_created;

    /**
     * Service message: the channel has been created. This field can‘t be received in a message coming through updates,
     * because bot can’t be a member of a channel when it is created. It can only be found in reply_to_message if
     * someone replies to a very first message in a channel.
     */
    Optional<Boolean> channel_chat_created;

    /**
     * The group has been migrated to a supergroup with the specified identifier. This number may be greater than
     * 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller
     * than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    Optional<Long> migrate_to_chat_id;

    /**
     * The supergroup has been migrated from a group with the specified identifier. This number may be greater than
     * 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller
     * than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    Optional<Long> migrate_from_chat_id;

    /**
     * Specified message was pinned. Note that the Message object in this field will not contain further
     * reply_to_message fields even if it is itself a reply.
     */
    Optional<Message> pinned_message;

    /**
     * Message is an invoice for a payment, information about the invoice.
     */
    Optional<Invoice> invoice;

    /**
     * Message is a service message about a successful payment, information about the payment.
     */
    Optional<SuccessfulPayment> successful_payment;

    public int getMessage_id() {
        return message_id;
    }

    public Optional<User> getFrom() {
        return from;
    }

    public int getDate() {
        return date;
    }

    public Chat getChat() {
        return chat;
    }

    public Optional<User> getForward_from() {
        return forward_from;
    }

    public Optional<Chat> getForward_from_chat() {
        return forward_from_chat;
    }

    public Optional<Integer> getForward_from_message_id() {
        return forward_from_message_id;
    }

    public Optional<Integer> getForward_date() {
        return forward_date;
    }

    public Optional<Integer> getEdit_date() {
        return edit_date;
    }

    public Optional<Message> getReply_to_message() {
        return reply_to_message;
    }

    public Optional<String> getText() {
        return text;
    }

    public Optional<MessageEntity[]> getEntities() {
        return entities;
    }

    public Optional<Audio> getAudio() {
        return audio;
    }

    public Optional<Document> getDocument() {
        return document;
    }

    public Optional<Game> getGame() {
        return game;
    }

    public Optional<PhotoSize[]> getPhoto() {
        return photo;
    }

    public Optional<Sticker> getSticker() {
        return sticker;
    }

    public Optional<Video> getVideo() {
        return video;
    }

    public Optional<Voice> getVoice() {
        return voice;
    }

    public Optional<VideoNote> getVideo_note() {
        return video_note;
    }

    public Optional<User[]> getNew_chat_members() {
        return new_chat_members;
    }

    public Optional<String> getCaption() {
        return caption;
    }

    public Optional<Contact> getContact() {
        return contact;
    }

    public Optional<Location> getLocation() {
        return location;
    }

    public Optional<Venue> getVenue() {
        return venue;
    }

    public Optional<User> getNew_chat_member() {
        return new_chat_member;
    }

    public Optional<User> getLeft_chat_member() {
        return left_chat_member;
    }

    public Optional<String> getNew_chat_title() {
        return new_chat_title;
    }

    public Optional<PhotoSize[]> getNew_chat_photo() {
        return new_chat_photo;
    }

    public Optional<Boolean> getDelete_chat_photo() {
        return delete_chat_photo;
    }

    public Optional<Boolean> getGroup_chat_created() {
        return group_chat_created;
    }

    public Optional<Boolean> getSupergroup_chat_created() {
        return supergroup_chat_created;
    }

    public Optional<Boolean> getChannel_chat_created() {
        return channel_chat_created;
    }

    public Optional<Long> getMigrate_to_chat_id() {
        return migrate_to_chat_id;
    }

    public Optional<Long> getMigrate_from_chat_id() {
        return migrate_from_chat_id;
    }

    public Optional<Message> getPinned_message() {
        return pinned_message;
    }

    public Optional<Invoice> getInvoice() {
        return invoice;
    }

    public Optional<SuccessfulPayment> getSuccessful_payment() {
        return successful_payment;
    }
}

