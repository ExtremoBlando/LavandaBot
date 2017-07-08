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
}
