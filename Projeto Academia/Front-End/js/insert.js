$(document).ready(function() {
    $('#contact_form').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            first_name: {
                validators: {
                        stringLength: {
                        min: 3,
                    },
                        notEmpty: {
                        message: 'Please supply a valid Name'
                    }
                }
            },
            CCid: {
                validators: {
                     stringLength: {
                        min: 8,
                    },
                    notEmpty: {
                        message: 'Please supply a valid ID with at least 8 digits'
                    }
                }
            },
            address: {
                validators: {
                     stringLength: {
                        min: 8,
                    },
                    notEmpty: {
                        message: 'Please supply a valid address'
                    }
                }
            },
            phone: {
                validators: {
                     stringLength: {
                        min: 9,
                    },
                    notEmpty: {
                        message: 'Please supply a valid Phone Number'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your email address'
                    },
                    emailAddress: {
                        message: 'Please supply a valid email address'
                    }
                }
            }
        }
        })
        .on('success.form.bv', function(e) {
            $('#success_message').slideDown({ opacity: "show" }, "slow") // Do something ...
                $('#contact_form').data('bootstrapValidator').resetForm();

            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
                console.log(result);
            }, 'json');
        });
});

function ekUpload(){
  function Init() {

    console.log("Upload Initialised");

    var fileSelect    = document.getElementById('file-upload'),
        fileDrag      = document.getElementById('file-drag'),
        submitButton  = document.getElementById('submit-button'),
        picSelect     = document.getElementById('pic-upload'),
        picDrag       = document.getElementById('pic-drag');

    fileSelect.addEventListener('change', fileSelectHandler, false);
    picSelect.addEventListener('change', picSelectHandler, false);

    var xhr = new XMLHttpRequest();
    if (xhr.upload) {
      fileDrag.addEventListener('dragover', fileDragHover, false);
      fileDrag.addEventListener('dragleave', fileDragHover, false);
      fileDrag.addEventListener('drop', fileSelectHandler, false);

      picDrag.addEventListener('dragover', picDragHover, false);
      picDrag.addEventListener('dragleave', picDragHover, false);
      picDrag.addEventListener('drop', picSelectHandler, false);
    }
  }

  function fileDragHover(e) {
    var fileDrag = document.getElementById('file-drag');

    e.stopPropagation();
    e.preventDefault();

    fileDrag.className = (e.type === 'dragover' ? 'hover' : 'modal-body file-upload');
  }

  function picDragHover(e) {
    var picDrag = document.getElementById('pic-drag');

    e.stopPropagation();
    e.preventDefault();
  }

  function fileSelectHandler(e) {
    // Fetch FileList object
    var files = e.target.files || e.dataTransfer.files;

    // Cancel event and hover styling
    fileDragHover(e);

    // Process all File objects
    for (var i = 0, f; f = files[i]; i++) {
      parseFile(f);
    }
  }

  function picSelectHandler(e){
    // Fetch PicList object
    var pic = e.target.files || e.dataTransfer.files;

    // Cancel event and hover styling
    picDragHover(e);

    //Proceess all Pic objects
    for (var i = 0, f; f = files[i]; i++) {
      parsePic(f);
    }
  }

  // Output
  function output(msg) {
    // Response
    var m = document.getElementById('messages');
    m.innerHTML = msg;
  }

  function parseFile(file) {

    console.log(file.name);
    output(
      '<strong>' + encodeURI(file.name) + '</strong>'
    );
    
    // var fileType = file.type;
    // console.log(fileType);
    var imageName = file.name;

    var isGood = (/\.(?=gif|jpg|png|jpeg)/gi).test(imageName);
    if (isGood) {
      document.getElementById('start').classList.add("hidden");
      document.getElementById('response').classList.remove("hidden");
      document.getElementById('notimage').classList.add("hidden");
      // Thumbnail Preview
      document.getElementById('file-image').classList.remove("hidden");
      document.getElementById('file-image').src = URL.createObjectURL(file);
    }
    else {
      document.getElementById('file-image').classList.add("hidden");
      document.getElementById('notimage').classList.remove("hidden");
      document.getElementById('start').classList.remove("hidden");
      document.getElementById('response').classList.add("hidden");
      document.getElementById("file-upload-form").reset();
    }
  }

  function parsePic(pic) {

    console.log(pic.name);
    output(
      '<strong>' + encodeURI(pic.name) + '</strong>'
    );
    
    // var fileType = file.type;
    // console.log(fileType);
    var imageName = pic.name;

    var isGood = (/\.(?=pdf)/gi).test(imageName);
    if (isGood) {
      document.getElementById('pic-start').classList.add("hidden");
      document.getElementById('pic-response').classList.remove("hidden");
      document.getElementById('pic-notimage').classList.add("hidden");
      // Thumbnail Preview
      document.getElementById('pic-image').classList.remove("hidden");
    }
    else {
      document.getElementById('pic-image').classList.add("hidden");
      document.getElementById('pic-notimage').classList.remove("hidden");
      document.getElementById('pic-start').classList.remove("hidden");
      document.getElementById('pic-response').classList.add("hidden");
      document.getElementById("pic-upload-form").reset();
    }
  }

  // Check for the various File API support.
  if (window.File && window.FileList && window.FileReader) {
    Init();
  } else {
    document.getElementById('file-drag').style.display = 'none';
  }
}
ekUpload();