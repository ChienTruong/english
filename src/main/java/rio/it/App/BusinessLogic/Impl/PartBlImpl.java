package rio.it.App.BusinessLogic.Impl;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rio.it.App.BusinessLogic.PartBl;
import rio.it.App.Model.PartQuestionModel;
import rio.it.App.Service.AccountService;
import rio.it.App.Service.PartService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Created by chien on 24/04/2018.
 */
@Component
public class PartBlImpl implements PartBl {

    private static final Logger LOGGER = LoggerFactory.getLogger(PartBlImpl.class);

    private AccountService accountService;
    private PartService partService;

    @Autowired
    public PartBlImpl(AccountService accountService, PartService partService) {
        this.accountService = accountService;
        this.partService = partService;
    }

    @Override
    public List<PartQuestionModel> getAllPartQuestion(String namePart, String emailUser) {
        if (namePart != null
                && emailUser != null) {
            if (partService.checkExist(namePart)) {

                return partService.getAllPartQuestionModelThisAccount(namePart, emailUser);
            }
        }
        return null;
    }

    @Override
    public PartQuestionModel getPartQuestionRandom(String namePart, String emailUser) {
        LOGGER.info("Get Random Part Question For Customer");
        if (namePart != null
                && emailUser != null) {
            if (this.partService.checkExist(namePart)) {
                // uuid of part question
                // map count the number of times done
                Map<UUID, Integer> historyUser = this.accountService.getHistoryOfUser(emailUser, namePart);
                // all part question of name part
                Map<UUID, PartQuestionModel> uuidPartQuestionModelMap = this.partService.getAllPartQuestionByNamePart(namePart);
                boolean isContainAll = historyUser.keySet().containsAll(uuidPartQuestionModelMap.keySet());
                UUID uuid = null;
                if (historyUser.isEmpty()
                        || !isContainAll) {
                    if (!isContainAll) {
                        uuidPartQuestionModelMap.keySet().removeAll(historyUser.keySet());
                    }
                    uuid = this.getRandomUuidOfSet(uuidPartQuestionModelMap.keySet());
                    return uuidPartQuestionModelMap.get(uuid);
                }
                uuid = this.getMin(historyUser);
                return uuidPartQuestionModelMap.get(uuid);
            }
        }
        return null;
    }

    private UUID getRandomUuidOfSet(Set<UUID> uuids) {
        if (!uuids.isEmpty()) {
            return uuids.iterator().next();
        }
        return null;
    }

    private UUID getMin(Map<UUID, Integer> historyUser) {
        int min = Integer.MAX_VALUE;
        UUID uuid = null;
        for (Map.Entry<UUID, Integer> uuidIntegerEntry : historyUser.entrySet()) {
            if (uuidIntegerEntry.getValue() < min) {
                uuid = uuidIntegerEntry.getKey();
                min = uuidIntegerEntry.getValue();
            }
        }
        return uuid;
    }
}
