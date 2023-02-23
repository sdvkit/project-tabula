package com.sdv.kit.projecttabula.mapper;

import com.sdv.kit.projecttabula.dto.TaskDto;
import com.sdv.kit.projecttabula.dto.TaskGroupDto;
import com.sdv.kit.projecttabula.model.Task;
import com.sdv.kit.projecttabula.model.TaskGroup;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-20T23:37:53+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class TaskGroupMapperImpl implements TaskGroupMapper {

    @Override
    public TaskGroup fromDto(TaskGroupDto taskGroupDto) {
        if ( taskGroupDto == null ) {
            return null;
        }

        TaskGroup.TaskGroupBuilder taskGroup = TaskGroup.builder();

        taskGroup.id( taskGroupDto.id() );
        taskGroup.name( taskGroupDto.name() );
        taskGroup.tasks( taskDtoSetToTaskSet( taskGroupDto.tasks() ) );

        return taskGroup.build();
    }

    @Override
    public TaskGroupDto toDto(TaskGroup taskGroup) {
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

    protected Task taskDtoToTask(TaskDto taskDto) {
        if ( taskDto == null ) {
            return null;
        }

        Task.TaskBuilder task = Task.builder();

        task.id( taskDto.id() );
        task.title( taskDto.title() );
        task.description( taskDto.description() );
        task.creationDate( taskDto.creationDate() );
        task.expirationDate( taskDto.expirationDate() );

        return task.build();
    }

    protected Set<Task> taskDtoSetToTaskSet(Set<TaskDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Task> set1 = new LinkedHashSet<Task>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TaskDto taskDto : set ) {
            set1.add( taskDtoToTask( taskDto ) );
        }

        return set1;
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
}
