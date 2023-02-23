package com.sdv.kit.projecttabula.mapper;

import com.sdv.kit.projecttabula.dto.TaskDto;
import com.sdv.kit.projecttabula.model.Task;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-20T23:37:53+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task fromDto(TaskDto taskDto) {
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

    @Override
    public TaskDto toDto(Task task) {
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
}
