package com.lucasmafra.socialnetworking.infrastructure.utilities;

import java.time.temporal.ChronoUnit;
import java.util.*;

public class ElapsedTimeFormatter {

    private static Map<ChronoUnit, String> unitTimeDictionary = new EnumMap<ChronoUnit, String>(ChronoUnit.class) {
        {
            put(ChronoUnit.DAYS, "day");
            put(ChronoUnit.HOURS, "hour");
            put(ChronoUnit.MINUTES, "minute");
            put(ChronoUnit.SECONDS, "second");
        }
    };

    public static String format(Date from, Date until) {
        UnitTime unitTime = unitTimeFrom(from, until);
        return buildMessage(unitTime.amount, unitTimeDictionary.get(unitTime.unit));
    }

    private static UnitTime unitTimeFrom(Date from, Date until) {
        List<ChronoUnit> units = getUnitsInDescendingOrder();

        // We try to find the proper unit by looking from the biggest unit (days) to the smallest (seconds)
        for (ChronoUnit unit : units) {
            Long duration = unit.between(from.toInstant(), until.toInstant());
            if (hasAtLeastOneUnit(duration)) {
                return new UnitTime(unit, duration);
            }
        }
        return null;
    }

    private static boolean hasAtLeastOneUnit(Long duration) {
        return duration > 0;
    }

    private static List<ChronoUnit> getUnitsInDescendingOrder() {
        List<ChronoUnit> units = new ArrayList<>(unitTimeDictionary.keySet());
        Collections.sort(units);
        Collections.reverse(units);
        return units;
    }

    private static String buildMessage(Long amount, String unit) {
        return amount + " " + unitAsPluralOrSingular(unit, amount) + " ago";
    }

    private static String unitAsPluralOrSingular(String unit, Long amount) {
        return amount == 1 ?
                unit :
                unit + 's';
    }

    private static class UnitTime {
        ChronoUnit unit;
        Long amount;

        public UnitTime(ChronoUnit unit, Long amount) {
            this.unit = unit;
            this.amount = amount;
        }
    }

}
