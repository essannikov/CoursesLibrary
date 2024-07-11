$(function(){
    const appendStudent = function(data){
        var studentCode = '<a href="#" class="student-link" data-id="' +
            data.id + '">' + data.name + '</a><br>';
        $('#student-list').
            append('<div>' + studentCode + '</div>');
    };

    //Loading students on load page
//    $.get('/students/', function(response){
//        for(i in response){
//            appendStudent(response[i]);
//        }
//    });

    //Show adding student form
    $('#show-add-student-form').click(function(){
        $('#student-form').css('display', 'flex');
    });

    //Closing adding student form
    $('#student-form').click(function(event){
        if(event.target === this){
            $(this).css('display', 'none');
        }
    });

    //Getting student
    $(document).on('click', '.student-link', function(){
        var link = $(this);
        var studentId = link.data('id');
        $.ajax({
            method: "GET",
            url: '/students/' + studentId,
            success: function(response){
                var code = '<span>Registration date:'+
                    response.registrationDate + '</span>';
                //console.log(code);
                //console.log($(this).parent());
                link.parent().append(code);
            },
            error: function(response){
                if(response.status == 404){
                    alert('Student not found!');
                }
            }
        });
        return false;
    });

    //Adding student
    $('#save-student').click(function(){
        var data = $('#student-form form').serialize();
        $.ajax({
            method: "POST",
            url: '/students/',
            data: data,
            success: function(response){
                $('#student-form').css('display', 'none');
                var student = {};
                student.id = response;
                var dataArray = $('#student-form form').serializeArray();
                for(i in dataArray){
                    student[dataArray[i]['name']] = dataArray[i]['value'];
                }
                appendStudent(student);
            }
        });
        return false;
    });
})