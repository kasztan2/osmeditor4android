package de.blau.android.presets;

import java.io.IOException;

import org.xmlpull.v1.XmlSerializer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import ch.poole.poparser.Po;

public abstract class PresetField {
    
    /**
     * Translation contexts
     */
    private String textContext;

    /**
     * Construct a new PresetField
     * 
     * @param key the key
     */
    protected PresetField() {
    }

    /**
     * Copy constructor
     * 
     * @param field PresetField to copy
     */
    protected PresetField(PresetField field) {
        this.textContext = field.textContext;
    }

    /**
     * Set the text translation context
     * 
     * @param textContext the translation context
     */
    public void setTextContext(@Nullable String textContext) {
        this.textContext = textContext;
    }

    /**
     * Get the text translation context
     * 
     * @return the textContext
     */
    @Nullable
    String getTextContext() {
        return textContext;
    }

    /**
     * Translate the translatable parts of this PresetField
     * 
     * Note this cannot be undone
     * 
     * @param po the object holding the translations
     */
    public abstract void translate(@NonNull Po po);

    /**
     * Translate a String
     * 
     * @param text the text to translate
     * @param po the translation object
     * @param context a translation context of null
     * @return the translated String
     */
    String translate(@NonNull String text, @NonNull Po po, @Nullable String context) {
        return context != null ? po.t(context, text) : po.t(text);
    }

    /**
     * Output the field in XML format
     * 
     * @param s an XmlSerialzer instance
     * @throws IllegalArgumentException if the serializer encountered an illegal argument
     * @throws IllegalStateException if the serializer detects an illegal state
     * @throws IOException if writing to the serializer fails
     */
    public abstract void toXml(@NonNull XmlSerializer s) throws IllegalArgumentException, IllegalStateException, IOException;
}
