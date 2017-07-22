package es.lavandadelpatio.auto.TelegramModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Optional;

/**
 * Created by raulm on 07/07/2017.
 */
public class Chat {

    /**
     *  Unique identifier for this chat. This number may be greater than 32 bits and some programming languages
     * 	may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    @Id
    private long id;

    /**
     * Type of chat, see ChatType doc
     */
    private ChatType type;

    /**
     * Title, for supergroups, channels and group chats
     */
    private Optional<String> title;

    /**
     * Username, for private chats, supergroups and channels if available
     */
    private Optional<String> username;

    /**
     * First name of the other party in a private chat
     */
    private Optional<String> first_name;

    /**
     * Last name of the other party in a private chat
     */
    private Optional<String> last_name;

    /**
     * Description, for supergroups and channel chats. Returned only in getChat.
     */
    private Optional<String> description;

    /**
     * Chat invite link, for supergroups and channel chats. Returned only in getChat.
     */
    private Optional<String> invite_link;

    /**
     * True if a group has ‘All Members Are Admins’ enabled.
     */
    private Optional<Boolean> all_members_are_administrators;

    /**
     * Chat photo. Returned only in getChat.
     */
    private Optional<ChatPhoto> photo;

    public long getId() {
        return id;
    }

    public ChatType getType() {
        return type;
    }

    public Optional<String> getTitle() {
        return title;
    }

    public Optional<String> getUsername() {
        return username;
    }

    public Optional<String> getFirst_name() {
        return first_name;
    }

    public Optional<String> getLast_name() {
        return last_name;
    }

    public Optional<String> getDescription() {
        return description;
    }

    public Optional<String> getInvite_link() {
        return invite_link;
    }

    public Optional<Boolean> getAll_members_are_administrators() {
        return all_members_are_administrators;
    }

    public Optional<ChatPhoto> getPhoto() {
        return photo;
    }
}
