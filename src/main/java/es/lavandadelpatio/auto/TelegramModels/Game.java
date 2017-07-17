package es.lavandadelpatio.auto.TelegramModels;

import javafx.animation.Animation;

import javax.persistence.Entity;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by raulm on 08/07/2017.
 */
public class Game {

    /**
     * Title of the game
     */
    String title;

    /**
     * Description of the game
     */
    String description;

    /**
     * Photo that will be displayed in the game message in chats.
     */
    List<PhotoSize> photo;

    /**
     * Brief description of the game or high scores included in the game message. Can be automatically edited to include current high scores for the game when the bot calls setGameScore, or manually edited using editMessageText. 0-4096 characters.
     */
    Optional<String> text;

    /**
     * Special entities that appear in text, such as usernames, URLs, bot commands, etc.
     */
    Optional<ArrayList<MessageEntity>> text_entities;

    /**
     * Animation that will be displayed in the game message in chats.
     */
    Optional<Animation> animation;
}
