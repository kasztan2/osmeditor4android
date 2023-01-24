package de.blau.android.presets;

import java.io.IOException;

import org.xmlpull.v1.XmlSerializer;

import ch.poole.poparser.Po;

public class PresetItemSeparatorField extends PresetField {

    @Override
    public void translate(Po po) {
        // nothing to translate
    }

    @Override
    public void toXml(XmlSerializer s) throws IllegalArgumentException, IllegalStateException, IOException {
        s.startTag("", PresetParser.ITEM_SEPARATOR);
        s.endTag("", PresetParser.ITEM_SEPARATOR);
    }
}
