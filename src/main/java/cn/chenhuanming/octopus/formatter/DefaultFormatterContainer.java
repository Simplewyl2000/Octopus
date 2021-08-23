package cn.chenhuanming.octopus.formatter;

import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenhuanming
 * Created at 2018/12/17
 */
@EqualsAndHashCode
public class DefaultFormatterContainer implements FormatterContainer {

    private Map<Class, Formatter> formatMap;

    public DefaultFormatterContainer() {
        formatMap = new HashMap<>();
        formatMap.put(Integer.class, new IntegerFormatter());
        formatMap.put(Integer.TYPE, new IntegerFormatter.PrimitiveFormatter());
        formatMap.put(Double.class, new DoubleFormatter());
        formatMap.put(Double.TYPE, new DoubleFormatter.PrimitiveFormatter());
        formatMap.put(Long.class, new LongFormatter());
        formatMap.put(Long.TYPE, new LongFormatter.PrimitiveFormatter());
        formatMap.put(Float.class, new FloatFormatter());
        formatMap.put(Float.TYPE, new FloatFormatter.PrimitiveFormatter());
        formatMap.put(Boolean.class, new BooleanFormatter());
        formatMap.put(Boolean.TYPE, new BooleanFormatter.PrimitiveFormatter());
        formatMap.put(Short.class, new ShortFormatter());
        formatMap.put(Short.TYPE, new ShortFormatter.PrimitiveFormatter());
        formatMap.put(BigDecimal.class, new BigDecimalFormatter());
        formatMap.put(String.class, new StringFormatter());
    }

    public <T> void addFormat(Class<T> clazz, Formatter<T> formatter) {
        formatMap.put(clazz, formatter);
    }


    @Override
    public <T> Formatter<T> get(Class<T> tClass) {
        return formatMap.get(tClass);
    }
}
