package tn.esprit.eventsproject.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.eventsproject.entities.Event;
import tn.esprit.eventsproject.repositories.EventRepository;
import tn.esprit.eventsproject.services.EventServicesImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class TestServiceEventImplTest {

    @Mock
    EventRepository eventRepository;

    @InjectMocks
    EventServicesImpl eventService;

    Event event = new Event(1, "Sample Event", LocalDate.now(), LocalDate.now().plusDays(5), 100.0f, new HashSet<>(), new HashSet<>());

    List<Event> events = Arrays.asList(
            new Event(1, "Event 1", LocalDate.now(), LocalDate.now().plusDays(3), 50.0f, new HashSet<>(), new HashSet<>()),
            new Event(2, "Event 2", LocalDate.now().plusDays(2), LocalDate.now().plusDays(7), 75.0f, new HashSet<>(), new HashSet<>())
    );



    @Test
    void testRetrieveAllEvents() {
        Mockito.when(eventRepository.findAll()).thenReturn(events);
        List<Event> retrievedEvents = eventService.getall();
        Assertions.assertNotNull(retrievedEvents);
        Assertions.assertEquals(2, retrievedEvents.size());
    }

    @Test
    void testAddEvent() {
        Mockito.when(eventRepository.save(event)).thenReturn(event);
        Event addedEvent = eventService.addAffectEvenParticipant(event);
        Assertions.assertNotNull(addedEvent);
    }
    @Test
    void testRetrieveEvent() {
        Mockito.when(eventRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(event));
        Event retrievedEvent = eventService.findone(1);
        Assertions.assertNotNull(retrievedEvent);
    }
    @Test
    void testUpdateEvent() {
        Event updatedEvent = new Event(1, "Updated Event", LocalDate.now().plusDays(2), LocalDate.now().plusDays(6), 120.0f, new HashSet<>(), new HashSet<>());
        Mockito.when(eventRepository.save(updatedEvent)).thenReturn(updatedEvent);
        Event updated = eventService.update(updatedEvent);
        Assertions.assertNotNull(updated);
        Assertions.assertEquals("Updated Event", updated.getDescription());
        Assertions.assertEquals(120.0f, updated.getCout());
    }

    @Test
    void testDeleteEvent() {
        Mockito.doNothing().when(eventRepository).deleteById(1);
        Object isDeleted = eventService.delete(1);
        Assertions.assertNull(isDeleted);
    }
}
