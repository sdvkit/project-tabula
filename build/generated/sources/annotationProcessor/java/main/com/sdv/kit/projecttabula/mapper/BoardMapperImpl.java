package com.sdv.kit.projecttabula.mapper;

import com.sdv.kit.projecttabula.dto.BoardDto;
import com.sdv.kit.projecttabula.dto.PersonDto;
import com.sdv.kit.projecttabula.dto.TaskDto;
import com.sdv.kit.projecttabula.dto.TaskGroupDto;
import com.sdv.kit.projecttabula.model.Board;
import com.sdv.kit.projecttabula.model.Person;
import com.sdv.kit.projecttabula.model.Task;
import com.sdv.kit.projecttabula.model.TaskGroup;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-26T15:14:20+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.5 (Oracle Corporation)"
)
public class BoardMapperImpl implements BoardMapper {

    @Override
    public BoardDto toDto(Board board) {
        if ( board == null ) {
            return null;
        }

        List<TaskGroupDto> taskGroupDtos = null;
        Long id = null;
        String name = null;
        Set<PersonDto> people = null;
        PersonDto creator = null;

        taskGroupDtos = taskGroupListToTaskGroupDtoList( board.getTaskGroups() );
        id = board.getId();
        name = board.getName();
        people = personSetToPersonDtoSet( board.getPeople() );
        creator = personToPersonDto( board.getCreator() );

        BoardDto boardDto = new BoardDto( id, name, people, creator, taskGroupDtos );

        return boardDto;
    }

    @Override
    public Board fromDto(BoardDto boardDto) {
        if ( boardDto == null ) {
            return null;
        }

        Board.BoardBuilder board = Board.builder();

        board.id( boardDto.id() );
        board.name( boardDto.name() );
        board.people( personDtoSetToPersonSet( boardDto.people() ) );
        board.creator( personDtoToPerson( boardDto.creator() ) );

        return board.build();
    }

    protected TaskDto taskToTaskDto(Task task) {
        if ( task == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String description = null;
        LocalDate creationDate = null;
        LocalDate expirationDate = null;

        id = task.getId();
        title = task.getTitle();
        description = task.getDescription();
        creationDate = task.getCreationDate();
        expirationDate = task.getExpirationDate();

        TaskDto taskDto = new TaskDto( id, title, description, creationDate, expirationDate );

        return taskDto;
    }

    protected Set<TaskDto> taskSetToTaskDtoSet(Set<Task> set) {
        if ( set == null ) {
            return null;
        }

        Set<TaskDto> set1 = new LinkedHashSet<TaskDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Task task : set ) {
            set1.add( taskToTaskDto( task ) );
        }

        return set1;
    }

    protected TaskGroupDto taskGroupToTaskGroupDto(TaskGroup taskGroup) {
        if ( taskGroup == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        Set<TaskDto> tasks = null;

        id = taskGroup.getId();
        name = taskGroup.getName();
        tasks = taskSetToTaskDtoSet( taskGroup.getTasks() );

        TaskGroupDto taskGroupDto = new TaskGroupDto( id, name, tasks );

        return taskGroupDto;
    }

    protected List<TaskGroupDto> taskGroupListToTaskGroupDtoList(List<TaskGroup> list) {
        if ( list == null ) {
            return null;
        }

        List<TaskGroupDto> list1 = new ArrayList<TaskGroupDto>( list.size() );
        for ( TaskGroup taskGroup : list ) {
            list1.add( taskGroupToTaskGroupDto( taskGroup ) );
        }

        return list1;
    }

    protected PersonDto personToPersonDto(Person person) {
        if ( person == null ) {
            return null;
        }

        String name = null;
        LocalDateTime createdAt = null;
        String email = null;
        String password = null;

        name = person.getName();
        createdAt = person.getCreatedAt();
        email = person.getEmail();
        password = person.getPassword();

        PersonDto personDto = new PersonDto( name, createdAt, email, password );

        return personDto;
    }

    protected Set<PersonDto> personSetToPersonDtoSet(Set<Person> set) {
        if ( set == null ) {
            return null;
        }

        Set<PersonDto> set1 = new LinkedHashSet<PersonDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Person person : set ) {
            set1.add( personToPersonDto( person ) );
        }

        return set1;
    }

    protected Person personDtoToPerson(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }

        Person.PersonBuilder person = Person.builder();

        person.name( personDto.name() );
        person.email( personDto.email() );
        person.password( personDto.password() );
        person.createdAt( personDto.createdAt() );

        return person.build();
    }

    protected Set<Person> personDtoSetToPersonSet(Set<PersonDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Person> set1 = new LinkedHashSet<Person>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PersonDto personDto : set ) {
            set1.add( personDtoToPerson( personDto ) );
        }

        return set1;
    }
}
