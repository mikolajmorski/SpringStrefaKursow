package com.morski.springstrefakursow.services;

import com.morski.springstrefakursow.domain.Quest;
import com.morski.springstrefakursow.domain.repository.QuestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

@RunWith(MockitoJUnitRunner.class)
public class QuestServiceTest {

    @Mock
    QuestRepository repositoryMock;

    @Test
    public void returnsNotStartedQuests() {
        List<Quest> quests = new ArrayList<>();
        Quest q1 = new Quest(1, "Test quest 1");
        Quest q2 = new Quest(2, "Test quest 2");
        Quest q3 = new Quest(3, "Test quest 3");

        q2.setStarted(true);

        quests.add(q1);
        quests.add(q2);
        quests.add(q3);
        when(repositoryMock.getAll()).thenReturn(quests);

        QuestService questService = new QuestService();
        questService.setQuestRepository(repositoryMock);

        List<Quest> allNotStartedQuests = questService.getAllNotStartedQuests();

        assertEquals("Size of returned quests", 2, allNotStartedQuests.size());
        assertThat(allNotStartedQuests, containsInAnyOrder(q1,q3));
    }
}
