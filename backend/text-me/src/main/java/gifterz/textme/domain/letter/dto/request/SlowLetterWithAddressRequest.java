package gifterz.textme.domain.letter.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gifterz.textme.domain.letter.entity.Address;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record SlowLetterWithAddressRequest(
        String receiverName,
        String postCode,
        String address,
        String addressDetail,
        String phoneNumber,
        String contents
) {
    public Address toAddress() {
        return new Address(postCode, address, addressDetail);
    }

    public ReceiverInfo toReceiverInfo() {
        return new ReceiverInfo(receiverName, phoneNumber);
    }
}