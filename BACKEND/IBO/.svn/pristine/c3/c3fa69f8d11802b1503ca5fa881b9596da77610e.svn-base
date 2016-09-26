package ulusoy.at.wicket.validation;



import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.util.convert.converter.AbstractConverter;

public class CentsToCurrencyConverter extends AbstractConverter<Long> {

    private static final long serialVersionUID = 1L;

    @Override
    public Long convertToObject(final String value, final Locale locale) {
        if (StringUtils.isBlank(value)) {
            return 0l;
        }
        final String[] splits = StringUtils.split(value, ",");
        Long toRet = Long.valueOf(splits[0]) * 100;
        if (splits.length > 1) {
            toRet += Long.valueOf(splits[1]);
        }
        return toRet;
    }

    @Override
    public String convertToString(final Long value, final Locale locale) {
        String toRet = value == null ? StringUtils.EMPTY : Long.toString(value);
        toRet = StringUtils.leftPad(toRet, 3, "0");
        return toRet.substring(0, toRet.length() - 2) + "," + toRet.substring(toRet.length() - 2, toRet.length());
    }

    @Override
    protected Class<Long> getTargetType() {
        return Long.class;
    }

}
