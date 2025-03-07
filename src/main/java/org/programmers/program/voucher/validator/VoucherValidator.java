package org.programmers.program.voucher.validator;

import org.programmers.program.voucher.model.Voucher;

import java.time.LocalDateTime;
import java.util.function.Predicate;

import static org.programmers.program.voucher.model.VoucherType.*;


public class VoucherValidator implements Predicate<Voucher> {
    @Override
    public boolean test(Voucher voucher) {
        if (voucher.isUsed())
            return false;
        if(voucher.getExpirationDate().isBefore(LocalDateTime.now()))
            return false;

        if (voucher.getDiscountAmount() < voucher.getVoucherType().getLowerBound()
                || voucher.getDiscountAmount() > voucher.getVoucherType().getUpperBound())
            return false;
        return true;
    }
}